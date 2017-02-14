package o.horbenko.list2treeMapperUtils;


public interface TreeMappable<TargetDTOType> {

    Long getId();

    Long getOwnerId();

    void addChild(TargetDTOType childToAdd);

}
