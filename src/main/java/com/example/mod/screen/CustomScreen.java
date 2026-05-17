package com.example.mod.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import net.minecraft.client.gui.GuiGraphicsExtractor;

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
                this.minecraft.getToastManager().addToast(
                    SystemToast.multiline(this.minecraft,
                        SystemToast.SystemToastId.NARRATOR_TOGGLE,
                        Text.literal("Hello World!"),
                        Text.literal("This is a toast."))
                );
            })
            .bounds(centerX - 60, centerY - 10, 120, 20)
            .build();

        this.addRenderableWidget(button);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.text(this.font,
            Text.literal("Special Button"),
            this.width / 2, 40,
            0xFFFFFFFF,
            true);
    }
}
