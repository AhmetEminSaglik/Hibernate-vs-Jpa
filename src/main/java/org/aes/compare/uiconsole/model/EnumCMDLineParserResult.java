package org.aes.compare.uiconsole.model;

public enum EnumCMDLineParserResult {
    RUN_FOR_CMDLINE(0),
    RUN_FOR_INDEX_VALUE(1),
    RUN_FOR_INVALID_COMMAND(2);

    int id;

    EnumCMDLineParserResult(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
