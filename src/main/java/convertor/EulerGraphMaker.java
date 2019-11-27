package convertor;


import utils.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EulerGraphMaker {

    private static Map emptyMap = new HashMap();
    private static Map<String, String> tempBinaryFeature = new HashMap<String, String>();

    /**
     * an example:
     * {
     * "node_type_num": 2,
     * "edge_type_num": 2,
     * "node_uint64_feature_num": 1,
     * "node_float_feature_num": 1,
     * "node_binary_feature_num": 1,
     * "edge_uint64_feature_num": 0,
     * "edge_float_feature_num": 2,
     * "edge_binary_feature_num": 0
     * }
     *
     * @return
     */
    public static String makeGraphMeta(boolean withNodeLabel) {
        int nodeBinaryFeatureNum = withNodeLabel ? 1 : 0;
        EulerGraphMeta eulerGraphMeta = new EulerGraphMeta(1, 1, 0, 0, nodeBinaryFeatureNum, 0, 0, 0);
        return JsonUtil.Marshal(eulerGraphMeta);
    }

    /**
     * {
     * "node_id": "顶点编号，int",
     * "node_type": "顶点类型，int",
     * "node_weight": "顶点权重，float",
     * "neighbor": {"边类型": {"邻居id": "权重", "...": "..."}, "...": "..."},
     * "uint64_feature": {"属性编号": ["int", "..."], "...": "..."},
     * "float_feature": {"属性编号": ["float", "..."], "...": "..."},
     * "binary_feature": {"属性编号": "string", "...": "..."},
     * "edge":[{
     * "src_id": "起点id, int",
     * "dst_id": "终点id, int",
     * "edge_type": "边类型, int",
     * "weight": "边权重, float",
     * "uint64_feature": {"属性编号": ["int", "..."], "...": ["int", "..."]},
     * "float_feature": {"属性编号": ["float", "..."], "...": ["float", "..."]},
     * "binary_feature": {"属性编号": "string", "...": "..."}
     * }, "..."]
     * }
     *
     * @return
     */
    public static String makeGraphBlockItem(long nodeId, String fullAuthorName, Map<Long, String> distNamesIdMap, boolean withNodeLabel) {
        int node_type = 0, edge_type = 0;
        float node_weight = 1.0f, edge_weight = 1.0f;

        Map<String, List<Integer>> uint64_feature = emptyMap;
        Map<String, List<Float>> float_feature = emptyMap;
        Map<String, String> edgeBinaryFeature = emptyMap;

        Map<String, String> binary_feature = new HashMap<String, String>();
        if (withNodeLabel) {
            binary_feature.put("0", fullAuthorName);
        }

        List<EulerGraphEdge> edge = new ArrayList<>();
        Map<String, Map<String, Float>> neighbor = new HashMap<String, Map<String, Float>>();
        Map<String, Float> edgeWeightMap = new HashMap<String, Float>();
        for (Map.Entry<Long, String> nameIDEntry : distNamesIdMap.entrySet()) {
            long distId = nameIDEntry.getKey();
            edgeWeightMap.put(distId + "", edge_weight);
//            String distAuthorName = nameIDEntry.getValue();
//            HashMap<String, String> edgeBinaryFeature = new HashMap<>();
//            edgeBinaryFeature.put("0", distAuthorName);
            edge.add(new EulerGraphEdge(
                    nodeId,
                    distId,
                    edge_type,
                    edge_weight,
                    uint64_feature,
                    float_feature,
                    edgeBinaryFeature
            ));
        }

        neighbor.put("0", edgeWeightMap);

        EulerGraphBlock eulerGraphBlock = new EulerGraphBlock(
                nodeId,
                node_type,
                node_weight,
                neighbor,
                uint64_feature,
                float_feature,
                binary_feature,
                edge
        );

        return JsonUtil.Marshal(eulerGraphBlock);
    }

    public static String makeGraphBlockItem(List<FullAuthorPair> fullAuthorPairs, boolean withNodeLabel) {
        long id = fullAuthorPairs.get(0).getId0();
        String fullNames = fullAuthorPairs.get(0).getFullnames0();

        HashMap<Long, String> authorIdNameMap = new HashMap<>();
        for (FullAuthorPair fullAuthorPair : fullAuthorPairs) {
            authorIdNameMap.put(fullAuthorPair.getId1(), fullAuthorPair.getFullnames1());
        }
        return makeGraphBlockItem(id, fullNames, authorIdNameMap, withNodeLabel);
    }
}
