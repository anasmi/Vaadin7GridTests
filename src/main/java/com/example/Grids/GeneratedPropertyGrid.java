package com.example.Grids;

import com.example.Model.Person;
import com.example.Service.PersonService;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.renderers.TextRenderer;

import java.util.Random;

public class GeneratedPropertyGrid {

        private VerticalLayout content = new VerticalLayout();
        private HorizontalLayout navigationBar = new HorizontalLayout();
        private Grid grid = new Grid();
        GeneratedPropertyContainer gpc;
        public GeneratedPropertyGrid() {

                BeanItemContainer<Person> container = new BeanItemContainer<Person>(
                        Person.class);
                container.addAll(PersonService.findAll());

                 gpc = new GeneratedPropertyContainer(
                        container);
                gpc.addGeneratedProperty("delete",
                        new PropertyValueGenerator<String>() {

                                @Override
                                public String getValue(Item item, Object itemId,
                                        Object propertyId) {
                                        return "Delete"; // The caption
                                }

                                @Override
                                public Class<String> getType() {
                                        return String.class;
                                }
                        });

                grid.setContainerDataSource(gpc);
                grid.setSelectionMode(Grid.SelectionMode.MULTI);
                grid.getColumn("firstName").setRenderer(new TextRenderer());
                grid.getColumn("id").setRenderer(new NumberRenderer("The id is %d"));
                grid.setFrozenColumnCount(2);



                grid.getColumn("delete")
                        .setRenderer(new ButtonRenderer(e -> // Java 8
                                grid.getContainerDataSource()
                                        .removeItem(e.getItemId())));

                initializeButtons();
                navigationBar.setSpacing(true);
                content.setMargin(true);
                content.addComponents(navigationBar, grid);
        }

        private void initializeButtons() {
                Button removeColumn = new Button("Remove column", e -> {
                        grid.removeColumn("lastName");
                });
                Button frozen = new Button("Change Frozen columns", e -> {
                        grid.setFrozenColumnCount(
                                grid.getFrozenColumnCount() == 2 ? 1 : 2);
                });
                navigationBar.addComponents(removeColumn, frozen);
        }

        public VerticalLayout getContent() {
                return content;
        }
}