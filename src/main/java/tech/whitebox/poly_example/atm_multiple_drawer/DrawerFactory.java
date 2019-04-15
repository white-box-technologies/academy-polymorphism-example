package tech.whitebox.poly_example.atm_multiple_drawer;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class DrawerFactory {

    static List<AtmDrawer> instantiateDrawers(){
        List<AtmDrawer> atmDrawers = new ArrayList<>();
        Reflections reflection = new Reflections("tech.whitebox.poly_example.atm_multiple_drawer");
        Set<Class<? extends AtmDrawer>> drawersClasses = reflection.getSubTypesOf(AtmDrawer.class);
        drawersClasses.forEach(clazz -> {
            try {
                atmDrawers.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return atmDrawers;
    }
}
