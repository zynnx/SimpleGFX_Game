package myGame;

class CustomSleep {
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Ignore the exception without any handling
        }
    }
}
