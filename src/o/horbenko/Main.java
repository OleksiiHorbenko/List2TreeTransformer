package o.horbenko;

import o.horbenko.dto.FooDTO;
import o.horbenko.list2treeMapperUtils.List2TreeMappingUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<FooDTO> rawTreePresentation = initData();

        FooDTO result = List2TreeMappingUtils
                .transformIntoTree(rawTreePresentation, null);

        System.out.println(result + "\n\n");

        System.out.println(result.getId());
    }

    private static List<FooDTO> initData() {

        List<FooDTO> result = new ArrayList<>();

        result.add(new FooDTO(5L, 8L));
        result.add(new FooDTO(6L, 4L));
        result.add(new FooDTO(4L, null));
        result.add(new FooDTO(1L, 8L));
        result.add(new FooDTO(2L, 4L));
        result.add(new FooDTO(7L, 2L));
        result.add(new FooDTO(3L, 8L));
        result.add(new FooDTO(8L, 2L));

        return result;
    }
}
