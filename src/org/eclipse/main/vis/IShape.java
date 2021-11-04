package org.eclipse.main.vis;

// Interface Forme commune
public interface IShape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}

