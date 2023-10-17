public class Main
{
    public static void main(String args[])
    {
        Behaviour normal = new NormalBehaviour();
        Behaviour defensive = new DefensiveBehaviour();
        Behaviour aggressive = new AggressiveBehaviour();

        Robot robot = new Robot();
        
        robot.setBehaviour(normal);
        robot.move();
        robot.move();
        
        robot.setBehaviour(defensive);
        robot.move();

        robot.setBehaviour(aggressive);
        robot.move();
        robot.move();
        robot.move();
    }
}