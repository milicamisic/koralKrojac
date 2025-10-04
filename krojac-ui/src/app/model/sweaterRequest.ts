export class SweaterRequest {
  bust!: number;
  torsoLength!: number;
  sleeveLength!: number;
  shoulderWidth!: number;
  fit!: string; // STANDARD, SLIM, LOOSE
  yarnThickness!: string; // e.g. THIN, MEDIUM, THICK

  constructor(init?: Partial<SweaterRequest>) {
    Object.assign(this, init);
  }
}
