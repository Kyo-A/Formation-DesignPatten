package org.eclipse.main.vis;

import java.util.ArrayList;
import java.util.List;

// Une forme composée
public class CompoundShape implements IShape {
    public int id;
    public List<IShape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(IShape shape) {
        children.add(shape);
    }
}
