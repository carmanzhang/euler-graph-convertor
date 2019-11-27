package convertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EulerGraphEdge {
    private long src_id;
    private long dst_id;
    private int edge_type;
    private float weight;
    private Map<String, List<Integer>> uint64_feature;
    private Map<String, List<Float>> float_feature;
    private Map<String, String> binary_feature;
}
