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

        //length
        System.out.print("length:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     dword [rbp-4H], 0\n");
        System.out.print("\tjmp     Llen_002\n");
        System.out.print("Llen_001:  add     dword [rbp-4H], 1\n");
        System.out.print("Llen_002:  mov     eax, dword [rbp-4H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjnz     Llen_001\n");
        System.out.print("\tmov     eax, dword [rbp-4H]\n");
        System.out.print("\tpop     rbp\n");
        System.out.print("\tret\n");


        //substring
        System.out.print("substring:\n");
        System.out.print("\tpush rbp\n");
        System.out.print("\tmov rbp,rsp\n");
        System.out.print("\tpush rdi\n");
        System.out.print("\tpush rsi\n");
        System.out.print("\tmov rdi,rdx\n");
        System.out.print("\tsub rdi,rsi\n");
        System.out.print("\tadd rdi,1\n");
        System.out.print("\tpush rdi\n");
        System.out.print("\tadd rdi,9\n");
        System.out.print("\tcall malloc\n");
        System.out.print("\tpop rdx\n");
        System.out.print("\tmov [rax],rdx\n");
        System.out.print("\tadd rax,8\n");
        System.out.print("\tpop rsi\n");
        System.out.print("\tpop rdi\n");
        System.out.print("\tadd rsi,rdi\n");
        System.out.print("\tmov rdi,rax\n");
        System.out.print("\tpush rdx\n");
        System.out.print("\tpush rax\n");
        System.out.print("\tcall memcpy\n");
        System.out.print("\tpop rax\n");
        System.out.print("\tpop rdx\n");
        System.out.print("\tmov qword[rax+rdx],0\n");
        System.out.print("\tmov rsp,rbp\n");
        System.out.print("\tpop rbp\n");
        System.out.print("\tret\n");
        System.out.print("\n");

        //parseInt
        System.out.print("parseInt:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tsub     rsp, 32\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     edi, 256\n");
        System.out.print("\tcall    malloc\n");
        System.out.print("\tmov     qword [rbp-8H], rax\n");
        System.out.print("\tmov     dword [rbp-10H], 0\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tjmp     Lpar_002\n");
        System.out.print("Lpar_001:  add     dword [rbp-10H], 1\n");
        System.out.print("Lpar_002:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Lpar_004\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Lpar_001\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Lpar_001\n");
        System.out.print("\tjmp     Lpar_004\n");
        System.out.print("Lpar_003:  mov     edx, dword [rbp-0CH]\n");
        System.out.print("\tmov     eax, edx\n");
        System.out.print("\tshl     eax, 2\n");
        System.out.print("\tadd     eax, edx\n");
        System.out.print("\tadd     eax, eax\n");
        System.out.print("\tmov     ecx, eax\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tmovsx   eax, al\n");
        System.out.print("\tadd     eax, ecx\n");
        System.out.print("\tsub     eax, 48\n");
        System.out.print("\tmov     dword [rbp-0CH], eax\n");
        System.out.print("\tadd     dword [rbp-10H], 1\n");
        System.out.print("Lpar_004:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 47\n");
        System.out.print("\tjle     Lpar_005\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjle     Lpar_003\n");
        System.out.print("Lpar_005:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tleave\n");
        System.out.print("\tret\n");


        //ord
        System.out.print("ord:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     dword [rbp-1CH], esi\n");
        System.out.print("\tmov     eax, dword [rbp-1CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tmovsx   eax, al\n");
        System.out.print("\tmov     dword [rbp-4H], eax\n");
        System.out.print("\tmov     eax, dword [rbp-4H]\n");
        System.out.print("\tpop     rbp\n");
        System.out.print("\tret\n");

        //add
        System.out.println("_add:");
        System.out.println("\tpush    rbp");
        System.out.println("\tmov     rbp, rsp");
        System.out.println("\tsub     rsp, 32");
        System.out.println("\tmov     qword [rbp-18H], rdi");
        System.out.println("\tmov     qword [rbp-20H], rsi");
        System.out.println("\tmov     edi, 256");
        System.out.println("\tcall    malloc");
        System.out.println("\tmov     qword [rbp-8H], rax");
        System.out.println("\tmov     dword [rbp-10H], 0");
        System.out.println("\tmov     dword [rbp-0CH], 0");
        System.out.println("\tjmp     sjtulc_002");
        System.out.println("sjtulc_001:");
        System.out.println("\tmov     eax, dword [rbp-10H]");
        System.out.println("\tmovsxd  rdx, eax");
        System.out.println("\tmov     rax, qword [rbp-8H]");
        System.out.println("\tadd     rdx, rax");
        System.out.println("\tmov     eax, dword [rbp-10H]");
        System.out.println("\tmovsxd  rcx, eax");
        System.out.println("\tmov     rax, qword [rbp-18H]");
        System.out.println("\tadd     rax, rcx");
        System.out.println("\tmovzx   eax, byte [rax]");
        System.out.println("\tmov     byte [rdx], al");
        System.out.println("\tadd     dword [rbp-10H], 1");
        System.out.println("sjtulc_002:");
        System.out.println("\tmov     eax, dword [rbp-10H]");
        System.out.println("\tmovsxd  rdx, eax");
        System.out.println("\tmov     rax, qword [rbp-18H]");
        System.out.println("\tadd     rax, rdx");
        System.out.println("\tmovzx   eax, byte [rax]");
        System.out.println("\ttest    al, al");
        System.out.println("\tjnz     sjtulc_001");
        System.out.println("\tjmp     sjtulc_004");
        System.out.println("sjtulc_003:");
        System.out.println("\tmov     edx, dword [rbp-0CH]");
        System.out.println("\tmov     eax, dword [rbp-10H]");
        System.out.println("\tadd     eax, edx");
        System.out.println("\tmovsxd  rdx, eax");
        System.out.println("\tmov     rax, qword [rbp-8H]");
        System.out.println("\tadd     rdx, rax");
        System.out.println("\tmov     eax, dword [rbp-0CH]");
        System.out.println("\tmovsxd  rcx, eax");
        System.out.println("\tmov     rax, qword [rbp-20H]");
        System.out.println("\tadd     rax, rcx");
        System.out.println("\tmovzx   eax, byte [rax]");
        System.out.println("\tmov     byte [rdx], al");
        System.out.println("\tadd     dword [rbp-0CH], 1");
        System.out.println("sjtulc_004:");
        System.out.println("\tmov     eax, dword [rbp-0CH]");
        System.out.println("\tmovsxd  rdx, eax");
        System.out.println("\tmov     rax, qword [rbp-20H]");
        System.out.println("\tadd     rax, rdx");
        System.out.println("\tmovzx   eax, byte [rax]");
        System.out.println("\ttest    al, al");
        System.out.println("\tjnz     sjtulc_003");
        System.out.println("\tmov     edx, dword [rbp-10H]");
        System.out.println("\tmov     eax, dword [rbp-0CH]");
        System.out.println("\tadd     eax, edx");
        System.out.println("\tmovsxd  rdx, eax");
        System.out.println("\tmov     rax, qword [rbp-8H]");
        System.out.println("\tadd     rax, rdx");
        System.out.println("\tmov     byte [rax], 0");
        System.out.println("\tmov     rax, qword [rbp-8H]");
        System.out.println("\tleave");
        System.out.println("\tret");




        int tmp = 8;
        for (Object obj:root.gen_var.var.keySet()){
            reg t = root.gen_var.var.get(obj);
            if (t.memory == null) {
                t.memory = "rbp-" + String.valueOf(tmp);
                tmp = tmp + 8;
            }
        }
        root.gen_var.name = "_general";
        print_dfs(root.gen_var, root.gen_var, 0);
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



            print_dfs(ftmp, ftmp, 0);


        }
    }

    void print_dfs(BasicBlock tmp, FuncBlock f, int c){
        System.out.println(tmp.name+":");
        if (tmp.name.equals(f.name)) {
            System.out.print("\tpush\trbp\n");
            System.out.print("\tmov\trbp, rsp\n");
            if (f.var_num % 2 == 1) System.out.print("\tsub\trsp, " + f.var_num*8+"\n");
            else System.out.print("\tsub\trsp, " + (f.var_num+1)*8+"\n");
        }
        if (tmp.name.equals("main")){
            System.out.print("\tcall\t _general\n");


        }

        for (int i = 0; i < tmp.content.size(); ++i) {
            if (tmp.content.get(i).op == Opcode.push) c++;
            if (tmp.content.get(i).op == Opcode.pop) c--;
            if (tmp.content.get(i).op == Opcode.call && c % 2 == 1){
                System.out.println("\tpush\trcx");
            }
            tmp.content.get(i).print(f);
            if (tmp.content.get(i).op == Opcode.call && c % 2 == 1){
                System.out.println("\tpop\trcx");
            }
        }
        if (tmp.Next != null){
            print_dfs(tmp.Next, f, c);
        }
//        if (tmp.name.equals(f.name)) {
//            System.out.print("\tmov\trsp, rbp\n");
//            System.out.print("\tpop\trbp\n");
//            System.out.print("\tret\n");
//        }

    }
}
