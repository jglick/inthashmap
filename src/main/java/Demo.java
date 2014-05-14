import cern.colt.map.OpenIntObjectHashMap;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.netbeans.insane.scanner.CountingVisitor;
import org.netbeans.insane.scanner.ScannerUtils;
public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("HashMap size: " + sizeof(useHashMap()));
        System.out.println("TIntObjectMap size: " + sizeof(useTIntObjectMap ()));
        System.out.println("IntHashMap size: " + sizeof(useIntHashMap()));
        System.out.println("OpenIntObjectHashMap size: " + sizeof(useOpenIntObjectHashMap()));
    }
    private static int sizeof(Object o) throws Exception {
        CountingVisitor counter = new CountingVisitor();
        ScannerUtils.scan(null, counter, Collections.singleton(o), false);
        return counter.getTotalSize();
    }
    private static Object useIntHashMap() {
        IntHashMap<String> m = new IntHashMap<>(1000, "?", String.class);
        Random r = new Random();
        for (int i = 0; i < 9999; i++) {
            m.put(r.nextInt(Integer.MAX_VALUE), "val" + i);
        }
        return m;
    }
    private static Object useHashMap() {
        Map<Integer,String> m = new HashMap<>(1000);
        Random r = new Random();
        for (int i = 0; i < 9999; i++) {
            m.put(r.nextInt(Integer.MAX_VALUE), "val" + i);
        }
        return m;
    }
    private static Object useTIntObjectMap() {
        TIntObjectMap<String> m = new TIntObjectHashMap<>(1000);
        Random r = new Random();
        for (int i = 0; i < 9999; i++) {
            m.put(r.nextInt(Integer.MAX_VALUE), "val" + i);
        }
        return m;
    }
    private static Object useOpenIntObjectHashMap() {
        OpenIntObjectHashMap m = new OpenIntObjectHashMap();
        Random r = new Random();
        for (int i = 0; i < 9999; i++) {
            m.put(r.nextInt(Integer.MAX_VALUE), "val" + i);
        }
        return m;
    }
}
