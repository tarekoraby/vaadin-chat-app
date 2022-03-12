package org.vaadin.tarek.chat;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatMaster {

    private List<UI> uiList = new ArrayList<>();

    public void sendMessage(String msg){
        for (UI ui: uiList){
            ui.access(() -> ((HasComponents)ui.getChildren().findFirst().get()).add(new Span(msg)));
        }
    }

    public void addUI(UI ui) {
        uiList.add(ui);
    }
}
