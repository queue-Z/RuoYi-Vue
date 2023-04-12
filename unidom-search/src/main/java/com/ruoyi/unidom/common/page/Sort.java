package com.ruoyi.unidom.common.page;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.ruoyi.unidom.common.page.Order.Direction;

public class Sort {
    private static final String SORT_DELLIMITER = ",";
    private List<Order> orders;

    public Sort() {
        this.orders = Collections.EMPTY_LIST;
    }

//    public Sort(String order) {
//        this(order);
//    }

    public Sort(String... orders) {
        this((List)Arrays.asList(orders).stream().map((p) -> {
            String[] elements = p.split(",");
            Optional<Order.Direction> direction = elements.length < 2 ? Optional.empty() : Optional.of(Enum.valueOf(Order.Direction.class, elements[1].toUpperCase()));
            Order.OrderBuilder<?, ?> builder = Order.builder();
            builder.direction(!direction.isPresent() ? Direction.ASC : (Order.Direction)direction.get());
            builder.property(elements[0].trim());
            Order order = Order.builder().direction(!direction.isPresent() ? Direction.ASC : (Order.Direction)direction.get()).property(elements[0].trim()).build();
            return order;
        }).collect(Collectors.toList()));
    }

    public Sort(Order... orders) {
        this(Arrays.asList(orders));
    }

    public Sort(List<Order> orders) {
        if (null != orders && !orders.isEmpty()) {
            this.orders = orders;
        } else {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }
    }

    protected Sort(final SortBuilder<?, ?> b) {
        this.orders = b.orders;
    }

    public static SortBuilder<?, ?> builder() {
        return new SortBuilderImpl();
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Sort)) {
            return false;
        } else {
            Sort other = (Sort)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$orders = this.getOrders();
                Object other$orders = other.getOrders();
                if (this$orders == null) {
                    if (other$orders != null) {
                        return false;
                    }
                } else if (!this$orders.equals(other$orders)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Sort;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $orders = this.getOrders();
        result = result * 59 + ($orders == null ? 43 : $orders.hashCode());
        return result;
    }

    public String toString() {
        return "Sort(orders=" + this.getOrders() + ")";
    }

    private static final class SortBuilderImpl extends SortBuilder<Sort, SortBuilderImpl> {
        private SortBuilderImpl() {
        }

        protected SortBuilderImpl self() {
            return this;
        }

        public Sort build() {
            return new Sort(this);
        }
    }

    public abstract static class SortBuilder<C extends Sort, B extends SortBuilder<C, B>> {
        private List<Order> orders;

        public SortBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B orders(final List<Order> orders) {
            this.orders = orders;
            return this.self();
        }

        public String toString() {
            return "Sort.SortBuilder(orders=" + this.orders + ")";
        }
    }
}
