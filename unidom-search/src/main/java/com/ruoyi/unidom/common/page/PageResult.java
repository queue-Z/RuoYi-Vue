package com.ruoyi.unidom.common.page;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PageResult<T> extends PageInfo {
    protected List<T> list;

    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
        this.size = list == null ? 0 : list.size();
    }

    public PageResult(List<T> list, long total, int pageNum, int pageSize) {
        this.list = list;
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.size = list == null ? 0 : list.size();
    }

    public PageResult(List<T> list, long total, PageCondition condition) {
        this.list = list;
        this.total = total;
        this.size = list == null ? 0 : list.size();
        this.pageNum = condition.getPage();
        this.pageSize = condition.getPageSize();
    }

    protected PageResult(final PageResultBuilder<T, ?, ?> b) {
        super(b);
        this.list = b.list;
    }

    public static <T> PageResultBuilder<T, ?, ?> pageResultBuilder() {
        return new PageResultBuilderImpl();
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(final List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "PageResult(list=" + this.getList() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResult)) {
            return false;
        } else {
            PageResult<?> other = (PageResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        return result;
    }

    public PageResult() {
    }

    public PageResult(final List<T> list) {
        this.list = list;
    }

    private static final class PageResultBuilderImpl<T> extends PageResultBuilder<T, PageResult<T>, PageResultBuilderImpl<T>> {
        private PageResultBuilderImpl() {
        }

        protected PageResultBuilderImpl<T> self() {
            return this;
        }

        public PageResult<T> build() {
            return new PageResult(this);
        }
    }

    public abstract static class PageResultBuilder<T, C extends PageResult<T>, B extends PageResultBuilder<T, C, B>> extends PageInfo.PageInfoBuilder<C, B> {
        private List<T> list;

        public PageResultBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B list(final List<T> list) {
            this.list = list;
            return this.self();
        }

        public String toString() {
            return "PageResult.PageResultBuilder(super=" + super.toString() + ", list=" + this.list + ")";
        }
    }
}
