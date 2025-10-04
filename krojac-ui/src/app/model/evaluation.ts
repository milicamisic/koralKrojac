export interface Evaluation {
  baseLength: number;
  totalLength: number;
  messages: string[];
  warnings: string[];
  recommendedFabrics: string[];
}