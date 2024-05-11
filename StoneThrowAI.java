public class StoneThrowAI {
    private static final double TARGET_DISTANCE = 5362.0; // The target distance in meters
    private static final int NUM_EPISODES = 100; // Number of episodes for training
    private static final double MAX_THROW_DISTANCE = 100000.0; // Maximum distance the stone can be thrown


    private double Eval = Integer.MAX_VALUE;

    // Method to throw the stone and get the distance
    private double throwStone() {
        return (Math.random() * MAX_THROW_DISTANCE);
    }
    public double train(){
        double d;
        double currEval;
        double predictedDistance = 0;
        for (int i = 0; i < NUM_EPISODES; i++){
            d = throwStone();
            currEval = Math.abs(1 - d/TARGET_DISTANCE);

            if (currEval < Eval){
                Eval = currEval;
                predictedDistance = d;
            }
        }
        return predictedDistance;
    }


    public static void main(String[] args) {
        StoneThrowAI ai = new StoneThrowAI();
        double predictedDistance = ai.train();
        System.out.println("Predicted throw distance: " + predictedDistance);
    }
}
