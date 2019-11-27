package convertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EulerGraphBlock {
    private long node_id;
    private int node_type;
    private float node_weight;
    private Map<String, Map<String, Float>> neighbor;
    private Map<String, List<Integer>> uint64_feature;
    private Map<String, List<Float>> float_feature;
    private Map<String, String> binary_feature;
    private List<EulerGraphEdge> edge;
}
