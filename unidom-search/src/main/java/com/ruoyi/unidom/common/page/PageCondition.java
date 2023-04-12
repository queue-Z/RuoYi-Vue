package com.ruoyi.unidom.common.page;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public class PageCondition {
    private static final Sort EMPTY_SORT = new Sort();
    private int page;
    private int pageSize;
    private Sort sort;

    public int getOffset() {
        return this.page * this.pageSize;
    }

    public int getLimit() {
        return this.pageSize;
    }

    protected PageCondition(final PageConditionBuilder<?, ?> b) {
        this.sort = EMPTY_SORT;
        this.page = b.page;
        this.pageSize = b.pageSize;
        this.sort = b.sort;
    }

    public static PageConditionBuilder<?, ?> builder() {
        return new PageConditionBuilderImpl();
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public Sort getSort() {
        return this.sort;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(final Sort sort) {
        this.sort = sort;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageCondition)) {
            return false;
        } else {
            PageCondition other = (PageCondition)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPage() != other.getPage()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$sort = this.getSort();
                Object other$sort = other.getSort();
                if (this$sort == null) {
                    if (other$sort == null) {
                        return true;
                    }
                } else if (this$sort.equals(other$sort)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageCondition;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getPage();
        result = result * 59 + this.getPageSize();
        Object $sort = this.getSort();
        result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
        return result;
    }

    public String toString() {
        return "PageCondition(page=" + this.getPage() + ", pageSize=" + this.getPageSize() + ", sort=" + this.getSort() + ")";
    }

    public PageCondition() {
        this.sort = EMPTY_SORT;
    }

    private static final class PageConditionBuilderImpl extends PageConditionBuilder<PageCondition, PageConditionBuilderImpl> {
        private PageConditionBuilderImpl() {
        }

        protected PageConditionBuilderImpl self() {
            return this;
        }

        public PageCondition build() {
            return new PageCondition(this);
        }
    }

    public abstract static class PageConditionBuilder<C extends PageCondition, B extends PageConditionBuilder<C, B>> {
        private int page;
        private int pageSize;
        private Sort sort;

        public PageConditionBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B page(final int page) {
            this.page = page;
            return this.self();
        }

        public B pageSize(final int pageSize) {
            this.pageSize = pageSize;
            return this.self();
        }

        public B sort(final Sort sort) {
            this.sort = sort;
            return this.self();
        }

        public String toString() {
            return "PageCondition.PageConditionBuilder(page=" + this.page + ", pageSize=" + this.pageSize + ", sort=" + this.sort + ")";
        }
    }
}
