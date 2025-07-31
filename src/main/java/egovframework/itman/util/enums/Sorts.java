package egovframework.itman.util.enums;

import lombok.Getter;

@Getter
public enum Sorts {
    ASC("asc"), DESC("desc");


    private final String sort;

    Sorts(String sort) {
        this.sort = sort;
    }

}
