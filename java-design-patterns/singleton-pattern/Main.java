public class Main
{
    public static void main(String args[])
    {
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println("Lazy: " + lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println("Lazy: " + lazy);
        
        SingletonEager eager = SingletonEager.getInstance();
        System.out.println("Eager: " + eager);
        eager = SingletonEager.getInstance();
        System.out.println("Eager: " + eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstance();
        System.out.println("Holder: " + holder);
        holder = SingletonLazyHolder.getInstance();
        System.out.println("Holder: " + holder);
    }
}