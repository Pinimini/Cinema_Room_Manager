class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (String e :
                args) {
            System.out.println(e);
        }
    }
}