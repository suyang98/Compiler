public class mayfinal {
    IR root;
    void transform(){
        for (Object obj : root.Blocks.keySet())
            System.out.println("global\t" + obj);
        for (int i = 0; i < root.gen_var.content.size(); ++i)
            System.out.println("global\t" + root.gen_var.content.get(i).src1.contxt);

        System.out.println("extern\tputs");


        System.out.println("section .data");


        System.out.println("section .text");

        for (Object key: root.Blocks.keySet()){
            FuncBlock ftmp = root.Blocks.get(key);
            int tmp = 8;
            for (Object obj:ftmp.var.keySet()){
                reg t = ftmp.var.get(obj);
                t.memory = "rbp-"+String.valueOf(tmp);
                tmp = tmp + 8;
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
        for (int i = 0; i < tmp.content.size(); ++i)
            tmp.content.get(i).print(f);
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
