package L5.model;

class Main1 {

    public static void main(String[] args) {
        E c = new E("5");
    }
}

class D {
    static {
        System.out.print("1");
    }

    D(){
        System.out.print("2");
    }

    D(String str){
        this();
        System.out.print("3");
    }
}

//14256

class E extends D {
    static {
        System.out.print("4");
    }

    E(){
        System.out.print("5");
    }

    E(String str){
        this();
        System.out.println("6");
    }
}