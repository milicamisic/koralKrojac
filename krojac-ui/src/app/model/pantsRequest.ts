export class PantsRequest {
  waist!: number;        // waist circumference in cm
  hips!: number;         // hip circumference in cm
  inseam!: number;       // inner leg length in cm
  outseam!: number;      // outer leg length in cm
  fit!: string;          // STANDARD, SLIM, LOOSE

  constructor(init?: Partial<PantsRequest>) {
    Object.assign(this, init);
  }
}
