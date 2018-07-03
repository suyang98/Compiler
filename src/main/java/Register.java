import java.util.HashMap;
import java.util.Map;

public class Register {
    Map<Integer, String> reg= new HashMap();
    Register(){
        reg.put(0, "rax");
        reg.put(1, "rbx");
        reg.put(2, "rcx");
        reg.put(3, "rdx");
        reg.put(4, "rsp");
        reg.put(5, "rbp");
        reg.put(6, "rsi");
        reg.put(7, "rdi");
        reg.put(8, "r8");
        reg.put(9, "r9");
        reg.put(10, "r10");
        reg.put(11, "r11");
        reg.put(12, "r12");
        reg.put(13, "r13");
        reg.put(14, "r14");
        reg.put(15, "r15");
    }

    String param(int i){
        if (i == 0) return "rdi";
        else if (i == 1) return "rsi";
        else if (i == 2) return "rdx";
        else if (i == 3) return "rcx";
        else if (i == 4) return "r8";
        else if (i == 5) return "r9";
        else return null;
    }

    String col(int i){
        if (i == 0) return "r10";
        else if (i == 1) return "r11";
        else if (i == 2) return "r12";
        else if (i == 3) return "r13";
        else if (i == 4) return "r14";
        else if (i == 5) return "r15";
        else return null;
    }

}
