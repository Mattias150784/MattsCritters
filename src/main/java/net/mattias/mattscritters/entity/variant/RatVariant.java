
package net.mattias.mattscritters.entity.variant;

public enum RatVariant {
    WHITE(0),
    GRAY(1),
    BLACK(2),
    BROWN(3);

    private final int id;

    RatVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static RatVariant byId(int id) {
        for (RatVariant variant : values()) {
            if (variant.getId() == id) {
                return variant;
            }
        }
        return WHITE;
    }
    }
