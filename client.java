public class client {
    public static void main(String[] args) throws Exception {
         backend c = new backend();
            c.addfirst(10);
            c.addfirst(20);
            c.addfirst(30);
            c.addlast(40);
            c.addlast(50);
            c.addatindex(25, 2);
            c.display();
                System.out.println(c.getfirst());
                System.out.println(c.getlast());
                System.out.println(c.getatindex(2));
                c.removefirst();
                c.removelast();
                c.removeatindex(1);
                c.display();
    } 
}
