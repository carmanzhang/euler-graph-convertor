package convertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EulerGraphMeta {
    private int node_type_num;
    private int edge_type_num;
    private int node_uint64_feature_num;
    private int node_float_feature_num;
    private int node_binary_feature_num;
    private int edge_uint64_feature_num;
    private int edge_float_feature_num;
    private int edge_binary_feature_num;
}
