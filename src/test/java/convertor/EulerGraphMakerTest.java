package convertor;

import org.junit.Test;

import java.util.HashMap;

public class EulerGraphMakerTest {
    @Test
    public void test01() {
        String s = EulerGraphMaker.makeGraphMeta(true);
        System.out.println(s);
    }

    @Test
    public void test02() {
        HashMap<Long, String> fullNameAuthorId = new HashMap<Long, String>() {{
                put(12345L, "jajaaj");
                put(67890L, "zxccdvv");
            }};

        String s = EulerGraphMaker.makeGraphBlockItem(34, "carman", fullNameAuthorId, false);
        System.out.println(s);
    }
}
