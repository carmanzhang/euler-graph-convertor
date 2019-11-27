package convertor;

import org.junit.Test;
import utils.JsonUtil;

import java.util.*;

public class EulerGraphTest {
    @Test
    public void test01() {
        EulerGraphBlock eulerGraphBlock = new EulerGraphBlock(1, 2, 3, null, new HashMap<>(), new HashMap<>(), new HashMap<>(), new ArrayList<EulerGraphEdge>());
        String marshal = JsonUtil.Marshal(eulerGraphBlock);
        System.out.println(marshal);
    }

    @Test
    public void test02() {
        Map<String, List<Integer>> uint64Features = new HashMap<String, List<Integer>>();
        uint64Features.put("uintkey0", Arrays.asList(1, 2, 3));
        uint64Features.put("uintkey1", Arrays.asList(1, 2, 3, 4));
        uint64Features.put("uintkey2", Arrays.asList(1, 2, 3, 4, 5));

        Map<String, List<Float>> floatFeatures = new HashMap<String, List<Float>>();
        floatFeatures.put("floatkey0", Arrays.asList(1.0f, 20.23f, 3.78f));
        floatFeatures.put("floatkey1", Arrays.asList(1.56f, 2.23f));

        Map<String, String> boolFeatures = new HashMap<String, String>();
        boolFeatures.put("boolfeatue01", "ahhaah");
        boolFeatures.put("boolfeatue02", "heihei");

        EulerGraphBlock eulerGraphBlock = new EulerGraphBlock(1, 2, 3, null, uint64Features, floatFeatures, boolFeatures, new ArrayList<EulerGraphEdge>());
        String marshal = JsonUtil.Marshal(eulerGraphBlock);
        System.out.println(marshal);
    }

    @Test
    public void test03() {
        System.out.println(JsonUtil.Marshal(new EulerGraphMeta(2,2,1,1,1,0,2,0)));
    }

}
