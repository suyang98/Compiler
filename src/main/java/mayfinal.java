import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class mayfinal {
    IR root;
    List<p> print_list = new ArrayList<>();
    List<lab> label_list = new ArrayList<>();
    Map<String, lab> label_map = new HashMap<>();
    void transform(){
        //for (Object obj : root.Blocks.keySet())
         //   System.out.println("global\t" + obj);

        System.out.println("global\tmain");
//        System.out.println("global\tprintln");
//        System.out.println("global\tprint");
//        System.out.println("global\tgetstring");
//        System.out.println("global\tgetint");
//        System.out.println("global\ttostring");
//        System.out.println("global\ttranstring");
        for (int i = 0; i < root.GV.size(); ++i)
            System.out.println("global\t_" + root.GV.get(i));

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
            System.out.println("_" + root.GV.get(i)+":\tdq\t0");
        for (Object key:root.signal.keySet()){
            System.out.print(key+":");
            String str = root.signal.get(key);
            for (int i = 1; i < str.length()-1; ++i){
                if (i + 1 < str.length()-1 && str.charAt(i) == '\\'){
                    switch (str.charAt(++i)){
                        case '\\' : System.out.print("\n\tdb\t" + 92);break;
                        case 'n'  : System.out.print("\n\tdb\t" + 10);break;
                        case '\"' : System.out.print("\n\tdb\t" + 34);break;
                    }
                }
                else System.out.print("\n\tdb\t\"" + root.signal.get(key).charAt(i)+"\"");
            }
            if (str.length() == 2) System.out.println("\tdb\t\"\",0,0");
            else System.out.println(",0,0");
        }



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

        //parseint
        System.out.print("parseint:\n");
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

//string.eq
        System.out.print("\t_sete:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     qword [rbp-20H], rsi\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tjmp     Leq_002\n");
        System.out.print("Leq_001:  add     dword [rbp-0CH], 1\n");
        System.out.print("Leq_002:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Leq_004\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Leq_001\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Leq_001\n");
        System.out.print("\tjmp     Leq_004\n");
        System.out.print("Leq_003:  add     dword [rbp-8H], 1\n");
        System.out.print("Leq_004:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Leq_005\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Leq_003\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Leq_003\n");
        System.out.print("Leq_005:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tcmp     eax, dword [rbp-8H]\n");
        System.out.print("\tjz      Leq_006\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Leq_010\n");
        System.out.print("Leq_006:  mov     dword [rbp-4H], 0\n");
        System.out.print("\tmov     dword [rbp-4H], 0\n");
        System.out.print("\tjmp     Leq_009\n");
        System.out.print("Leq_007:  mov     eax, dword [rbp-4H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-4H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjz      Leq_008\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Leq_010\n");
        System.out.print("Leq_008:  add     dword [rbp-4H], 1\n");
        System.out.print("Leq_009:  mov     eax, dword [rbp-4H]\n");
        System.out.print("\tcmp     eax, dword [rbp-0CH]\n");
        System.out.print("\tjl      Leq_007\n");
        System.out.print("\tmov     eax, 1\n");
        System.out.print("Leq_010:  pop     rbp\n");
        System.out.print("\tret\n");

        //string.l
        System.out.print("_setl:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     qword [rbp-20H], rsi\n");
        System.out.print("\tmov     dword [rbp-10H], 0\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tjmp     Ll_012\n");
        System.out.print("Ll_011:  add     dword [rbp-10H], 1\n");
        System.out.print("Ll_012:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Ll_014\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Ll_011\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Ll_011\n");
        System.out.print("\tjmp     Ll_014\n");
        System.out.print("Ll_013:  add     dword [rbp-0CH], 1\n");
        System.out.print("Ll_014:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Ll_015\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Ll_013\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Ll_013\n");
        System.out.print("Ll_015:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tcmp     dword [rbp-10H], eax\n");
        System.out.print("\tcmovle  eax, dword [rbp-10H]\n");
        System.out.print("\tmov     dword [rbp-4H], eax\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tjmp     Ll_019\n");
        System.out.print("Ll_016:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjge     Ll_017\n");
        System.out.print("\tmov     eax, 1\n");
        System.out.print("\tjmp     Ll_021\n");
        System.out.print("Ll_017:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjle     Ll_018\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Ll_021\n");
        System.out.print("Ll_018:  add     dword [rbp-8H], 1\n");
        System.out.print("Ll_019:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tcmp     eax, dword [rbp-4H]\n");
        System.out.print("\tjl      Ll_016\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tcmp     eax, dword [rbp-0CH]\n");
        System.out.print("\tjl      Ll_020\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Ll_021\n");
        System.out.print("Ll_020:  mov     eax, 1\n");
        System.out.print("Ll_021:  pop     rbp\n");
        System.out.print("\tret\n");

        //string.g
        System.out.print("_setg:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     qword [rbp-20H], rsi\n");
        System.out.print("\tmov     dword [rbp-10H], 0\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tjmp     Lg_023\n");
        System.out.print("Lg_022:  add     dword [rbp-10H], 1\n");
        System.out.print("Lg_023:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Lg_025\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Lg_022\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Lg_022\n");
        System.out.print("\tjmp     Lg_025\n");
        System.out.print("Lg_024:  add     dword [rbp-0CH], 1\n");
        System.out.print("Lg_025:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Lg_026\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Lg_024\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Lg_024\n");
        System.out.print("Lg_026:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tcmp     dword [rbp-10H], eax\n");
        System.out.print("\tcmovle  eax, dword [rbp-10H]\n");
        System.out.print("\tmov     dword [rbp-4H], eax\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tjmp     Lg_030\n");
        System.out.print("Lg_027:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjle     Lg_028\n");
        System.out.print("\tmov     eax, 1\n");
        System.out.print("\tjmp     Lg_032\n");
        System.out.print("Lg_028:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjge     Lg_029\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Lg_032\n");
        System.out.print("Lg_029:  add     dword [rbp-8H], 1\n");
        System.out.print("Lg_030:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tcmp     eax, dword [rbp-4H]\n");
        System.out.print("\tjl      Lg_027\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tcmp     eax, dword [rbp-0CH]\n");
        System.out.print("\tjg      Lg_031\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Lg_032\n");
        System.out.print("Lg_031:  mov     eax, 1\n");
        System.out.print("Lg_032:  pop     rbp\n");
        System.out.print("\tret\n");

        //string.le
        System.out.print("\t_setle:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     qword [rbp-20H], rsi\n");
        System.out.print("\tmov     dword [rbp-10H], 0\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tjmp     Llege_002\n");
        System.out.print("Llege_001:  add     dword [rbp-10H], 1\n");
        System.out.print("Llege_002:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Llege_004\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Llege_001\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Llege_001\n");
        System.out.print("\tjmp     Llege_004\n");
        System.out.print("Llege_003:  add     dword [rbp-0CH], 1\n");
        System.out.print("Llege_004:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Llege_005\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Llege_003\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Llege_003\n");
        System.out.print("Llege_005:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tcmp     dword [rbp-10H], eax\n");
        System.out.print("\tcmovle  eax, dword [rbp-10H]\n");
        System.out.print("\tmov     dword [rbp-4H], eax\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tjmp     Llege_009\n");
        System.out.print("Llege_006:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjge     Llege_007\n");
        System.out.print("\tmov     eax, 1\n");
        System.out.print("\tjmp     Llege_011\n");
        System.out.print("Llege_007:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjle     Llege_008\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Llege_011\n");
        System.out.print("Llege_008:  add     dword [rbp-8H], 1\n");
        System.out.print("Llege_009:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tcmp     eax, dword [rbp-4H]\n");
        System.out.print("\tjl      Llege_006\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tcmp     eax, dword [rbp-0CH]\n");
        System.out.print("\tjle     Llege_010\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Llege_011\n");
        System.out.print("\tLlege_010:  mov     eax, 1\n");
        System.out.print("\tLlege_011:  pop     rbp\n");
        System.out.print("\tret\n");

        //string.ge
        System.out.print("\t_setge:\n");
        System.out.print("\tpush    rbp\n");
        System.out.print("\tmov     rbp, rsp\n");
        System.out.print("\tmov     qword [rbp-18H], rdi\n");
        System.out.print("\tmov     qword [rbp-20H], rsi\n");
        System.out.print("\tmov     dword [rbp-10H], 0\n");
        System.out.print("\tmov     dword [rbp-0CH], 0\n");
        System.out.print("\tjmp     Llege_013\n");
        System.out.print("Llege_012:  add     dword [rbp-10H], 1\n");
        System.out.print("Llege_013:  mov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Llege_015\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Llege_012\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Llege_012\n");
        System.out.print("\tjmp     Llege_015\n");
        System.out.print("Llege_014:  add     dword [rbp-0CH], 1\n");
        System.out.print("Llege_015:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjz      Llege_016\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\ttest    al, al\n");
        System.out.print("\tjs      Llege_014\n");
        System.out.print("\tmov     eax, dword [rbp-0CH]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     al, 57\n");
        System.out.print("\tjg      Llege_014\n");
        System.out.print("Llege_016:  mov     eax, dword [rbp-0CH]\n");
        System.out.print("\tcmp     dword [rbp-10H], eax\n");
        System.out.print("\tcmovle  eax, dword [rbp-10H]\n");
        System.out.print("\tmov     dword [rbp-4H], eax\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tmov     dword [rbp-8H], 0\n");
        System.out.print("\tjmp     Llege_020\n");
        System.out.print("Llege_017:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjle     Llege_018\n");
        System.out.print("\tmov     eax, 1\n");
        System.out.print("\tjmp     Llege_022\n");
        System.out.print("Llege_018:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rdx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-18H]\n");
        System.out.print("\tadd     rax, rdx\n");
        System.out.print("\tmovzx   edx, byte [rax]\n");
        System.out.print("\tmov     eax, dword [rbp-8H]\n");
        System.out.print("\tmovsxd  rcx, eax\n");
        System.out.print("\tmov     rax, qword [rbp-20H]\n");
        System.out.print("\tadd     rax, rcx\n");
        System.out.print("\tmovzx   eax, byte [rax]\n");
        System.out.print("\tcmp     dl, al\n");
        System.out.print("\tjge     Llege_019\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Llege_022\n");
        System.out.print("Llege_019:  add     dword [rbp-8H], 1\n");
        System.out.print("Llege_020:  mov     eax, dword [rbp-8H]\n");
        System.out.print("\tcmp     eax, dword [rbp-4H]\n");
        System.out.print("\tjl      Llege_017\n");
        System.out.print("\tmov     eax, dword [rbp-10H]\n");
        System.out.print("\tcmp     eax, dword [rbp-0CH]\n");
        System.out.print("\tjge     Llege_021\n");
        System.out.print("\tmov     eax, 0\n");
        System.out.print("\tjmp     Llege_022\n");
        System.out.print("Llege_021:  mov     eax, 1\n");
        System.out.print("Llege_022:  pop     rbp\n");
        System.out.print("\tret\n");


        int tmp = 8;
        for (Object obj:root.gen_var.var.keySet()){
            reg t = root.gen_var.var.get(obj);
            if (t.memory == null && t.contxt.indexOf("%") != -1) {
                t.memory = "rbp-" + String.valueOf(tmp);
                tmp = tmp + 8;
            }
        }
        root.gen_var.name = "_general";
        print_dfs(root.gen_var, root.gen_var, 0);
        sent t1 = new sent("mov", "rsp","rbp");
        sent t2 = new sent("pop","rbp");
        sent t3 = new sent("ret");
        print_list.add(t1);
        print_list.add(t2);
        print_list.add(t3);


        for (Object key: root.Blocks.keySet()){
            FuncBlock ftmp = root.Blocks.get(key);
            tmp = 8;
            for (Object obj:ftmp.var.keySet()){
                reg t = ftmp.var.get(obj);
                if (t.memory == null && t.contxt.indexOf("%") != -1) {
                    t.memory = "rbp-" + String.valueOf(tmp);
                    tmp = tmp + 8;
                }
            }


            print_dfs(ftmp, ftmp, 0);


        }
    }

    void out_func(){
        sent t1 = new sent("pop", "r15");
        print_list.add(t1);
        sent t2 = new sent("pop", "r14");
        print_list.add(t2);
        sent t3 = new sent("pop", "r13");
        print_list.add(t3);
        sent t4 = new sent("pop", "r12");
        print_list.add(t4);
    }

    void print_dfs(BasicBlock tmp, FuncBlock f, int c){
        if (tmp.name.indexOf("main") != -1) {
            lab tmp1 = new lab("main:");
            print_list.add(tmp1);
            tmp1.loc = print_list.size();
            label_map.put(tmp1.s, tmp1);
            label_list.add(tmp1);
        }
        else {
            lab tmp1 = new lab(tmp.name+":");
            print_list.add(tmp1);
            tmp1.loc = print_list.size();
            label_map.put(tmp1.s, tmp1);
            label_list.add(tmp1);
        }
        if (tmp.name.equals(f.name)) {
            sent tmp2 = new sent("push","rbp");
            print_list.add(tmp2);
            sent tmp3 = new sent("mov","rbp","rsp");
            print_list.add(tmp3);
            if (f.var_num % 2 == 1) {
                sent tmp4 = new sent("sub","rsp", String.valueOf(f.var_num*8));
                print_list.add(tmp4);
            }
            else {
                sent tmp4 = new sent("sub","rsp", String.valueOf((f.var_num+1)*8));
                print_list.add(tmp4);
            }
        }
        if (tmp.name.indexOf("main") != -1){
            sent tmp5 = new sent("push","r10");
            sent tmp6 = new sent("push","r11");
            sent tmp7 = new sent("call","_general");
            sent tmp8 = new sent("pop","r11");
            sent tmp9 = new sent("pop","r10");
            print_list.add(tmp5);
            print_list.add(tmp6);
            print_list.add(tmp7);
            print_list.add(tmp8);
            print_list.add(tmp9);
        }

        for (int i = 0; i < tmp.content.size(); ++i) {
            Tern t = tmp.content.get(i);
            if (f.name.indexOf("main") ==-1 &&(t.op == Opcode.leave||
                    (t.op == Opcode.mov && t.src1.contxt.equals("rsp") && t.src2.contxt.equals("rbp")))) out_func();

            if (!t.Is_Dead) t.print(f, print_list, label_map, label_list);
        }
        if (tmp.Next != null){
            print_dfs(tmp.Next, f, c);
        }

    }

    void optim(){
        for (int i = 0; i < print_list.size(); ++i){
            p t = print_list.get(i);
//            if (t instanceof sent && ((sent) t).operation.equals("mov") && ((sent) t).s1.equals("rax")){
//                p tt = print_list.get(i+1);
//                if (tt instanceof  sent && ((sent) tt).operation.equals("mov") && ((sent) tt).s2.equals("rax")){
//                    if (((sent) t).s2.indexOf("[")==-1 || ((sent) tt).s1.indexOf("[")==-1) {
//                        ((sent) t).s1 = ((sent) tt).s2;
//                        tt.flag = false;
//                        i++;
//                    }
//                }
//            }
            if (t instanceof sent && ((sent) t).operation.equals("mov") && ((sent) t).s1.equals(((sent) t).s2)) t.flag = false;
            if (t instanceof sent && (((sent)t).operation.indexOf("j") != -1 || ((sent) t).operation.equals("call")))
                if (label_map.get(((sent) t).s1+":")!=null)label_map.get(((sent) t).s1+":").appear.add(i);
        }
        for (Object obj:label_map.keySet()){
            lab t = label_map.get(obj);
            if (t.appear.size()==0 && !t.s.equals("_general:") && !t.s.equals("main:")) t.flag = false;
        }
    }

    void out(){
        for (int i = 0; i < print_list.size(); ++i){
            p t = print_list.get(i);
            if (!t.flag) continue;
            if (t instanceof lab) ((lab) t).print();
            if (t instanceof sent) ((sent) t).print();
        }
    }

}
