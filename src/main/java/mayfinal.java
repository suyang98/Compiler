public class mayfinal {
    IR root;
    void transform(){
        for (Object obj : root.Blocks.keySet())
            System.out.println("global\t" + obj);

        System.out.println("global\t_general");
        System.out.println("global\tprintln");
        System.out.println("global\tprint");
        System.out.println("global\tgetstring");
        System.out.println("global\tgetint");
        System.out.println("global\ttostring");
        System.out.println("global\ttranstring");
        for (int i = 0; i < root.GV.size(); ++i)
            System.out.println("global\t" + root.GV.get(i));

        System.out.println("");
        System.out.println("extern\tmalloc");
        System.out.println("extern\tsprintf");
        System.out.println("extern\tprintf");
        System.out.println("extern\tputs");
        System.out.println("extern\tstrlen");
        System.out.println("extern\tmemcpy");
        System.out.println("extern\tscanf");

        System.out.println("\nsection .data");
        for (int i = 0; i < root.GV.size(); ++i)
            System.out.println(root.GV.get(i)+":\tdq\t0");
        for (Object key:root.signal.keySet())
            System.out.println(key+":\tdb\t"+root.signal.get(key)+",0,0");



        System.out.println("intbuffer:\tdq 0");
        System.out.println("format1:\tdb\t\"%lld\",0");
        System.out.println("format2:\tdb\t\"%s\",0,0");


        System.out.println("\nsection .bss");
        System.out.println("stringbuffer:\tresb 256");


        System.out.println("\nsection .text");


        //println
        System.out.print("println:\n");
        System.out.print("\tcall puts\n");
        System.out.print("\tret\n");

        //print
        System.out.print("print:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tmov rax,0\n");
        System.out.print("\tmov rsi,rdi\n");
        System.out.print("\tmov rdi,format2\n");
        System.out.print("\tcall printf\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");

        //getString
        System.out.print("transtring:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tcall strlen\n");
        System.out.print("\tpush rdi\n");
        System.out.print("\tmov rdi,rax\n");
        System.out.print("\tpush rdi\n");
        System.out.print("\tadd rdi,9\n");
        System.out.print("\tcall malloc\n");
        System.out.print("\tpop rdi\n");
        System.out.print("\tmov [rax],rdi\n");
        System.out.print("\tadd rax,8\n");
        System.out.print("\tmov rdx,rdi\n");
        System.out.print("\tadd rdx,1\n");
        System.out.print("\tmov rdi,rax\n");
        System.out.print("\tpop rsi\n");
        System.out.print("\tsub rsp,8\n");
        System.out.print("\tpush rax\n");
        System.out.print("\tcall memcpy\n");
        System.out.print("\tpop rax\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");
        System.out.print("\n");
        System.out.print("getString:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tmov rax,0\n");
        System.out.print("\tmov rdi,format2\n");
        System.out.print("\tmov rsi,stringbuffer\n");
        System.out.print("\tcall scanf\n");
        System.out.print("\tmov rdi,stringbuffer\n");
        System.out.print("\tcall transtring\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");


        //getInt
        System.out.print("getint:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tmov rax,0\n");
        System.out.print("\tmov rdi,format1\n");
        System.out.print("\tmov rsi,intbuffer\n");
        System.out.print("\tcall scanf\n");
        System.out.print("\tmov rax,[intbuffer]\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");

        //toString
        System.out.print("tostring:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tmov rdx,rdi\n");
        System.out.print("\tmov rax,0\n");
        System.out.print("\tmov rdi,stringbuffer\n");
        System.out.print("\tmov rsi,format1\n");
        System.out.print("\tcall sprintf\n");
        System.out.print("\tmov rdi,stringbuffer\n");
        System.out.print("\tcall transtring\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");


        int tmp = 8;
        for (Object obj:root.gen_var.var.keySet()){
            reg t = root.gen_var.var.get(obj);
            if (t.memory == null) {
                t.memory = "rbp-" + String.valueOf(tmp);
                tmp = tmp + 8;
            }
        }
        root.gen_var.name = "_general";
        print_dfs(root.gen_var, root.gen_var);
        System.out.print("\tmov\trsp, rbp\n");
        System.out.print("\tpop\trbp\n");
        System.out.print("\tret\n");


        for (Object key: root.Blocks.keySet()){
            FuncBlock ftmp = root.Blocks.get(key);
            tmp = 8;
            for (Object obj:ftmp.var.keySet()){
                reg t = ftmp.var.get(obj);
                if (t.memory == null) {
                    t.memory = "rbp-" + String.valueOf(tmp);
                    tmp = tmp + 8;
                }
            }



            print_dfs(ftmp, ftmp);


        }
    }

    void print_dfs(BasicBlock tmp, FuncBlock f){
        System.out.println(tmp.name+":");
        if (tmp.name.equals(f.name)) {
            System.out.print("\tpush\trbp\n");
            System.out.print("\tmov\trbp, rsp\n");
            System.out.print("\tsub\trsp, " + f.var_num*8+"\n");
        }
        if (tmp.name.equals("main")){
            System.out.print("\tcall\t _general\n");




        }
        for (int i = 0; i < tmp.content.size(); ++i) {
            tmp.content.get(i).print(f);
        }
        if (tmp.Next != null){
            print_dfs(tmp.Next, f);
        }
//        if (tmp.name.equals(f.name)) {
//            System.out.print("\tmov\trsp, rbp\n");
//            System.out.print("\tpop\trbp\n");
//            System.out.print("\tret\n");
//        }

    }
}
