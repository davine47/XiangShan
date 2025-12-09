mill -i -Djvm-xmx=6G -Djvm-xss=256m xiangshan.runMain xiangshan.backend.fu.NewCSR.NewCSRMain   \
		--config DefaultConfig --firtool-opt "--repl-seq-mem --repl-seq-mem-file=XSTop.sv.conf"		\
		--num-cores 1 --target systemverilog --firtool-opt "-O=release --disable-annotation-unknown --lowering-options=explicitBitcast,disallowLocalVariables,disallowPortDeclSharing,locationInfoStyle=none" \
		--split-verilog --dump-fir  --fpga-platform --disable-all --reset-gen --firtool-opt --ignore-read-enable-mem
