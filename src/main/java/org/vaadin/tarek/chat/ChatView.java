package org.vaadin.tarek.chat;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class ChatView extends VerticalLayout {

    private ChatMaster chatMaster;
    private TextField message;
    private Button send;

    public ChatView(ChatMaster chatMaster) {
        this.chatMaster = chatMaster;
        message = new TextField("Message");
        send = new Button("Send");

        send.addClickListener(e -> {
            chatMaster.sendMessage(message.getValue());
        });

        add(message, send);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        chatMaster.addUI(UI.getCurrent());
    }
}
