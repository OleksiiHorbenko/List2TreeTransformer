package o.horbenko.dto;

import o.horbenko.list2treeMapperUtils.TreeMappable;

import java.util.ArrayList;
import java.util.List;

public class FooDTO implements TreeMappable<FooDTO>{

    private Long id;
    private Long ownerId;
    private List<FooDTO> nodes;
    private String someString;

    public FooDTO(Long id, Long ownerId) {
        this.id = id;
        this.ownerId = ownerId;
        this.nodes = new ArrayList<>();
        this.someString = "id" + id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", nodes=" + nodes +
                ", someString='" + someString + '\'' +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getOwnerId() {
        return ownerId;
    }

    @Override
    public void addChild(FooDTO childToAdd) {
        this.nodes.add(childToAdd);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<FooDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<FooDTO> nodes) {
        this.nodes = nodes;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }
}
