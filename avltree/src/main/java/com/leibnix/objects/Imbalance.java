package com.leibnix.objects;

public enum Imbalance {
        LL("ll"),
        RR("rr"),
        LR("lr"),
        RL("rl"),
        IT_IS_BALANCED("balanced");
    
        private String type;
    
        Imbalance(String imbalanceType){
            this.type = imbalanceType;
        }
    
        public boolean isSimple(){
            return this == LL || this == RR;
        }

        public boolean isDouble(){
            return this == LR || this == RL;
        }
    
        @Override
        public String toString(){
            return this.type;
        }

}
