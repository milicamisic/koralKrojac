export interface BlouseRequest {
  bust: number;
  waist: number;
  torsoLength: number;
  shoulder: number;
  neck: number;
  collarType: string;   // "klasična", "mandarinska", "oversized", "bez"
  sleeveType: string;   // e.g. "kratki", "dugi", "bez"
  fit: string;          // e.g. "Loose", "Slim", "Standard"
}
