package com.example.mod.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class CustomScreen extends Screen {

    public CustomScreen() {
        super(Text.literal("Benim Özel Menüm"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        ButtonWidget button = ButtonWidget.builder(
            Text.literal("Hello World"),
            btn -> {
                this.client.getToastManager().addToast(
                    SystemToast.multiline(this.client,
                        SystemToast.SystemToastId.NARRATOR_TOGGLE,
                        Text.literal("Hello World!"),
                        Text.literal("This is a toast."))
                );
            })
            .position(centerX - 60, centerY - 10)
            .size(120, 20)
            .build();

        this.addDrawableChild(button);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Special Button"),
            this.width / 2, 40, 0xFFFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }
}
