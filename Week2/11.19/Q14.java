public class Q14 {
    public static void main(String[] args) throws InterruptedException {
        // --- Part 1: Single-Threaded Comparison (1,000 appends) ---
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < 1000; i++) {
            sb.append("a");
            sbf.append("a");
        }

        System.out.println("=== Single-Threaded Output ===");
        System.out.println("StringBuilder length: " + sb.length());
        System.out.println("StringBuffer length:  " + sbf.length());
        System.out.println("Outputs identical?    " + sb.toString().equals(sbf.toString()));

        // --- Part 2: Multi-Threaded Race Condition Test ---
        StringBuilder sharedBuilder = new StringBuilder();
        StringBuffer sharedBuffer = new StringBuffer();

        // Thread 1 & 2 appending 1,000 times each to StringBuilder (Expected: 2,000)
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) sharedBuilder.append("a");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) sharedBuilder.append("a");
        });

        t1.start();
        t2.start();
        t1.join(); // Wait for Thread 1 to finish
        t2.join(); // Wait for Thread 2 to finish

        // Thread 3 & 4 appending 1,000 times each to StringBuffer (Expected: 2,000)
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) sharedBuffer.append("a");
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) sharedBuffer.append("a");
        });

        t3.start();
        t4.start();
        t3.join(); // Wait for Thread 3 to finish
        t4.join(); // Wait for Thread 4 to finish

        System.out.println("\n=== Multi-Threaded Output (Expected: 2000) ===");
        System.out.println("Shared StringBuilder length: " + sharedBuilder.length());
        System.out.println("Shared StringBuffer length:  " + sharedBuffer.length());
    }
}
