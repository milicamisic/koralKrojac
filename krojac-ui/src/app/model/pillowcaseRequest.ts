export class PillowcaseRequest {
  length!: number; // pillow length
  width!: number;  // pillow width

  constructor(init?: Partial<PillowcaseRequest>) {
    Object.assign(this, init);
  }
}
