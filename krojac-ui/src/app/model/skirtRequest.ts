export class SkirtRequest {
  type!: string;     // A-line, Pencil, Circle
  waist!: number;    // waist circumference in cm
  hips!: number;     // hip circumference in cm
  length!: number;   // skirt length in cm

  constructor(init?: Partial<SkirtRequest>) {
    Object.assign(this, init);
  }
}
