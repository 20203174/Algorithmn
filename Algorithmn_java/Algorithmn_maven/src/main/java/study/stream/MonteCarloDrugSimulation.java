package study.stream;

import java.util.Iterator;
import java.util.Random;

public class MonteCarloDrugSimulation {
    public static void main(String[] args) {
        int totalParticles = 10000;
        int numIterations = 10000;
        double targetProbability = 0.2;

        Iterator<Boolean> particleIterator = new Iterator<Boolean>() {
            private int particlesGenerated = 0;
            private Random random = new Random();
            @Override
            public boolean hasNext() {
                return particlesGenerated < totalParticles;
            }

            @Override
            public Boolean next() {
                particlesGenerated++;
                return random.nextDouble() < targetProbability;
            }
        };
        int reactedParticles = 0;

        for(int i = 0; i < numIterations; i++) {
            Boolean particle = particleIterator.next();
            if(particle){
                reactedParticles++;
            }
        }
        double observedProbability = (double) reactedParticles / totalParticles;
        System.out.println("목표 약품 반응 확률: "+ targetProbability);
        System.out.println("시뮬레이션 결과 약품 반응 확률: "+observedProbability);
    }
}
