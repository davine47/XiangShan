package xiangshan.backend.fu

import chisel3._
import chisel3.util._
import top.{ArgParser, Generator}
import xiangshan.backend.fu.wrapper.{Alu, MulUnit}
import xiangshan.{XSCoreParamsKey, XSTileKey}



object FuMain extends App {
  val (config, firrtlOpts, firtoolOpts) = ArgParser.parse(
    args :+ "--disable-always-basic-diff" :+ "--dump-fir" :+ "--fpga-platform" :+ "--target" :+ "verilog")

  val defaultConfig = config.alterPartial({
    // Get XSCoreParams and pass it to the "small module"
    case XSCoreParamsKey => config(XSTileKey).head
  })

  Generator.execute(
    firrtlOpts :+ "--full-stacktrace" :+ "--target-dir" :+ "backend",
    //new Alu(FuConfig.AluCfg)(defaultConfig).suggestName("Alu"),
   new AluDataModule(false)(defaultConfig).suggestName("XiangShan_ALU"),
    firtoolOpts
  )

  println("done")
}