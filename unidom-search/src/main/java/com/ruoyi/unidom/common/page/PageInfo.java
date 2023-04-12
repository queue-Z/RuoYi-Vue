package com.ruoyi.unidom.common.page;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PageInfo {
    protected long total;
    protected int pageNum = 0;
    protected int pageSize;
    protected int size;

    protected PageInfo(final PageInfoBuilder<?, ?> b) {
        this.total = b.total;
        this.pageNum = b.pageNum;
        this.pageSize = b.pageSize;
        this.size = b.size;
    }

    public static PageInfoBuilder<?, ?> builder() {
        return new PageInfoBuilderImpl();
    }

    public long getTotal() {
        return this.total;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getSize() {
        return this.size;
    }

    public void setTotal(final long total) {
        this.total = total;
    }

    public void setPageNum(final int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public String toString() {
        return "PageInfo(total=" + this.getTotal() + ", pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", size=" + this.getSize() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageInfo)) {
            return false;
        } else {
            PageInfo other = (PageInfo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotal() != other.getTotal()) {
                return false;
            } else if (this.getPageNum() != other.getPageNum()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                return this.getSize() == other.getSize();
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageInfo;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        long $total = this.getTotal();
        result = result * 59 + (int)($total >>> 32 ^ $total);
        result = result * 59 + this.getPageNum();
        result = result * 59 + this.getPageSize();
        result = result * 59 + this.getSize();
        return result;
    }

    public PageInfo() {
    }

    public PageInfo(final long total, final int pageNum, final int pageSize, final int size) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.size = size;
    }

    private static final class PageInfoBuilderImpl extends PageInfoBuilder<PageInfo, PageInfoBuilderImpl> {
        private PageInfoBuilderImpl() {
        }

        protected PageInfoBuilderImpl self() {
            return this;
        }

        public PageInfo build() {
            return new PageInfo(this);
        }
    }

    public abstract static class PageInfoBuilder<C extends PageInfo, B extends PageInfoBuilder<C, B>> {
        private long total;
        private int pageNum;
        private int pageSize;
        private int size;

        public PageInfoBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B total(final long total) {
            this.total = total;
            return this.self();
        }

        public B pageNum(final int pageNum) {
            this.pageNum = pageNum;
            return this.self();
        }

        public B pageSize(final int pageSize) {
            this.pageSize = pageSize;
            return this.self();
        }

        public B size(final int size) {
            this.size = size;
            return this.self();
        }

        public String toString() {
            return "PageInfo.PageInfoBuilder(total=" + this.total + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", size=" + this.size + ")";
        }
    }
}

