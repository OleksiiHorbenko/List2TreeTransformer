package o.horbenko.list2treeMapperUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List2TreeMappingUtils {

    public static <DTOType extends TreeMappable>
    DTOType transformIntoTree(List<DTOType> rawTreePresentation, Long rootNodeId) {
        DTOType rootNode = null;
        Map<Long, List<DTOType>> bufferIdsMap = new HashMap<>();


        for (DTOType currentItem : rawTreePresentation) {

            appendChildIdByRef(currentItem, currentItem.getOwnerId(), bufferIdsMap);

            if (currentItem.getOwnerId() == rootNodeId)
                rootNode = currentItem;
        }

        return collectIntoTree(rootNode, bufferIdsMap);
    }

    private static <DTOType extends TreeMappable>
    DTOType collectIntoTree(DTOType parent, Map<Long, List<DTOType>> bufferIdsMap) {
        long parentId = parent.getId();

        if (!bufferIdsMap.containsKey(parentId)) return parent;

        for (DTOType child : bufferIdsMap.get(parentId)) {
            collectIntoTree(child, bufferIdsMap);
            parent.addChild(child);
        }

        return parent;
    }



    private static <DTOType extends TreeMappable>
    void appendChildIdByRef(DTOType childToAdd,
                            Long ownerId,
                            Map<Long, List<DTOType>> bufferIdsMap) {

        if (ownerId == null) return;

        if (!bufferIdsMap.containsKey(ownerId))
            bufferIdsMap.put(ownerId, new ArrayList<>());

        bufferIdsMap.get(ownerId).add(childToAdd);
    }


}
