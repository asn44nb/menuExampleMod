package com.example.client;

import com.example.mod.screen.CustomScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {

            dispatcher.register(
                ClientCommandManager.literal("menü")
                    .executes(context -> {
                        MinecraftClient.getInstance().setScreen(new CustomScreen());
                        return 1;
                    })
            );

            dispatcher.register(
                ClientCommandManager.literal("custommenu")
                    .executes(context -> {
                        MinecraftClient.getInstance().setScreen(new CustomScreen());
                        return 1;
                    })
            );
        });
    }
}
