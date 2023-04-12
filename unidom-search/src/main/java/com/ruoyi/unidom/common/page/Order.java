package com.ruoyi.unidom.common.page;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public class Order {
    private Direction direction;
    private String property;

    protected Order(final OrderBuilder<?, ?> b) {
        this.direction = b.direction;
        this.property = b.property;
    }

    public static OrderBuilder<?, ?> builder() {
        return new OrderBuilderImpl();
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getProperty() {
        return this.property;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public void setProperty(final String property) {
        this.property = property;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Order)) {
            return false;
        } else {
            Order other = (Order)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$direction = this.getDirection();
                Object other$direction = other.getDirection();
                if (this$direction == null) {
                    if (other$direction != null) {
                        return false;
                    }
                } else if (!this$direction.equals(other$direction)) {
                    return false;
                }

                Object this$property = this.getProperty();
                Object other$property = other.getProperty();
                if (this$property == null) {
                    if (other$property != null) {
                        return false;
                    }
                } else if (!this$property.equals(other$property)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $direction = this.getDirection();
        result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
        Object $property = this.getProperty();
        result = result * 59 + ($property == null ? 43 : $property.hashCode());
        return result;
    }

    public String toString() {
        return "Order(direction=" + this.getDirection() + ", property=" + this.getProperty() + ")";
    }

    public Order() {
    }

    private static final class OrderBuilderImpl extends OrderBuilder<Order, OrderBuilderImpl> {
        private OrderBuilderImpl() {
        }

        protected OrderBuilderImpl self() {
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    public abstract static class OrderBuilder<C extends Order, B extends OrderBuilder<C, B>> {
        private Direction direction;
        private String property;

        public OrderBuilder() {
        }

        protected abstract B self();

        public abstract C build();

        public B direction(final Direction direction) {
            this.direction = direction;
            return this.self();
        }

        public B property(final String property) {
            this.property = property;
            return this.self();
        }

        public String toString() {
            return "Order.OrderBuilder(direction=" + this.direction + ", property=" + this.property + ")";
        }
    }

    public static enum Direction {
        ASC,
        DESC;

        private Direction() {
        }

        public boolean isAscending() {
            return this.equals(ASC);
        }

        public boolean isDescending() {
            return this.equals(DESC);
        }
    }
}
