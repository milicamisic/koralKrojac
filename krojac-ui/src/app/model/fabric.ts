export interface Fabric {
  id: number;
  name: string;
  type: string;
  width: number;
  stretchPercentage: number;
  shrinkagePercentage: number;
  hasNap: boolean;
  drape: string;
  gsm: number;
  category: string;
  pricePerMeter: number;
  inStock: number;
  season: string;
}