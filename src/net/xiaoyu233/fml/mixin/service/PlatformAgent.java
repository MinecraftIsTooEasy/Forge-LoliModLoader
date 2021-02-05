package net.xiaoyu233.fml.mixin.service;

import net.xiaoyu233.fml.FishModLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.spongepowered.asm.launch.platform.IMixinPlatformAgent.AcceptResult;
import org.spongepowered.asm.launch.platform.IMixinPlatformServiceAgent;
import org.spongepowered.asm.launch.platform.MixinPlatformAgentAbstract;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.launch.platform.container.IContainerHandle;
import org.spongepowered.asm.mixin.MixinEnvironment.Phase;
import org.spongepowered.asm.util.IConsumer;

import java.util.Collection;

public class PlatformAgent extends MixinPlatformAgentAbstract implements IMixinPlatformServiceAgent {
   private static Logger log;
   private static AbstractAppender appender;
   private static Level oldLevel;

   public AcceptResult accept(MixinPlatformManager manager, IContainerHandle handle) {
      return AcceptResult.ACCEPTED;
   }

   public String getPhaseProvider() {
      return null;
   }

   public void prepare() {
   }

   public void initPrimaryContainer() {
      this.injectRemapper();
   }

   private void injectRemapper() {
   }

   public void inject() {
   }

   public void init() {
   }

   public String getSideName() {
      return FishModLoader.isServer() ? "SERVER" : "CLIENT";
   }

   public Collection<IContainerHandle> getMixinContainers() {
      return null;
   }

   public void wire(Phase phase, IConsumer<Phase> phaseConsumer) {
      super.wire(phase, phaseConsumer);
      if (phase == Phase.PREINIT) {
         begin(phaseConsumer);
      }

   }

   static void begin(IConsumer<Phase> delegate) {
      org.apache.logging.log4j.Logger fmlLog = LogManager.getLogger("FishModLoader");
      if (fmlLog instanceof Logger) {
         log = fmlLog;
         oldLevel = log.getLevel();
         appender = new PlatformAgent.MixinAppender(delegate);
         appender.start();
         log.addAppender(appender);
         log.setLevel(Level.ALL);
      }
   }

   public void unwire() {
      end();
   }

   static void end() {
      if (log != null) {
         log.removeAppender(appender);
      }

   }

   static class MixinAppender extends AbstractAppender {
      private final IConsumer<Phase> delegate;

      MixinAppender(IConsumer<Phase> delegate) {
         super("MixinLogWatcherAppender", (Filter)null, (Layout)null);
         this.delegate = delegate;
      }

      public void append(LogEvent event) {
         if ("Starting Minecraft".equals(event.getMessage().getFormattedMessage())) {
            this.delegate.accept(Phase.INIT);
            if (PlatformAgent.log.getLevel() == Level.ALL) {
               PlatformAgent.log.setLevel(PlatformAgent.oldLevel);
            }

         }
      }
   }
}
