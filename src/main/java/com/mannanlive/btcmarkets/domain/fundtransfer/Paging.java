package com.mannanlive.btcmarkets.domain.fundtransfer;

public class Paging {
    private String newer;
    private String older;

    public String getNewer() {
        return newer;
    }

    public void setNewer(String newer) {
        this.newer = newer;
    }

    public String getOlder() {
        return older;
    }

    public void setOlder(String older) {
        this.older = older;
    }

    @Override
    public String toString() {
        return "Paging{newer='" + newer + '\'' + ", older='" + older + '\'' + '}';
    }
}
